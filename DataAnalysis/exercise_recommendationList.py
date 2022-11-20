#!/usr/bin/env python
# coding: utf-8

# In[1]:


#판다스 설치
#pip install pandas


# # 전체 데이터

# In[2]:


import pandas as pd
data = pd.read_csv('/Users/soy/Desktop/app/KS_DSPSN_FTNESS_MESURE_ACCTO_RECOMEND_MVM_INFO_202205.csv') 
data.head()


# In[3]:


data


# # 각 열 데이터 종류 분석

# In[4]:


#장애 종류
data['TROBL_TY_NM'].unique()


# In[5]:


#장애 등급 종류
data['TROBL_GRAD_NM'].unique()


# In[6]:


#운동 종류
data['RECOMEND_MVM_NM'].unique()


# In[7]:


#나이 대
data['AGRDE_FLAG_NM'].unique()


# In[8]:


#각 장애별 데이터 개수(중복 포함)
data['TROBL_TY_NM'].value_counts()


# In[9]:


data_drop_duplicate=data.drop_duplicates(['RECOMEND_MVM_NM'])
data_drop_duplicate.head()


# In[10]:


#준비 운동 종류
data_drop_duplicate_pre=data_drop_duplicate[data_drop_duplicate['SPORTS_STEP_NM']=='준비운동']
data_drop_duplicate_pre['RECOMEND_MVM_NM'].unique()


# In[11]:


#본 운동 종류
data_drop_duplicate_main=data_drop_duplicate[data_drop_duplicate['SPORTS_STEP_NM']=='본운동']
data_drop_duplicate_main['RECOMEND_MVM_NM'].unique()


# In[12]:


#마무리 운동 종류
data_drop_duplicate_finish=data_drop_duplicate[data_drop_duplicate['SPORTS_STEP_NM']=='마무리운동']
data_drop_duplicate_finish['RECOMEND_MVM_NM'].unique()


# # 

# # 1) 시각 장애 데이터 분석

# In[13]:


#전 등급 시각 장애 데이터
eye_data = pd.DataFrame()
eye_data = data[data['TROBL_TY_NM']=='시각장애']
eye_data


# In[14]:


#시각 장애인 준비 운동 빈도 수
eye_data_pre_count = pd.DataFrame()
eye_data_pre_count = data[(data['TROBL_TY_NM']=='시각장애') & (data['SPORTS_STEP_NM']=='준비운동')]
eye_data_pre_count['RECOMEND_MVM_NM'].value_counts()


# In[15]:


#시각 장애인 준비 운동별 비율
eye_data_pre_count['RECOMEND_MVM_NM'].value_counts(normalize=True)


# In[16]:


#시각 장애인 본 운동 빈도 수
eye_data_main_count = pd.DataFrame()
eye_data_main_count = data[(data['TROBL_TY_NM']=='시각장애') & (data['SPORTS_STEP_NM']=='본운동')]
eye_data_main_count['RECOMEND_MVM_NM'].value_counts()


# In[17]:


#시각 장애인 마무리 운동 빈도 수
eye_data_finish_count = pd.DataFrame()
eye_data_finish_count = data[(data['TROBL_TY_NM']=='시각장애') & (data['SPORTS_STEP_NM']=='마무리운동')]
eye_data_finish_count['RECOMEND_MVM_NM'].value_counts()


# ## 시각장애 운동 중복 제거

# In[18]:


#중복 제거된 시각 장애 운동 개수
eye_exercise=eye_data['RECOMEND_MVM_NM'].unique()
len(eye_exercise)

eye_data_drop_duplicate=eye_data.drop_duplicates(['RECOMEND_MVM_NM'])
eye_data.drop_duplicates(['RECOMEND_MVM_NM']).shape[0]


# In[19]:


#중복 제거된 시각 장애 운동 데이터
eye_data_drop_duplicate.head()


# In[20]:


#시각장애 준비운동 종류
eye_data_drop_duplicate_pre=eye_data_drop_duplicate[eye_data_drop_duplicate['SPORTS_STEP_NM']=='준비운동']
eye_data_drop_duplicate_pre.head()


# In[21]:


#시각장애 메인운동 종류
eye_data_drop_duplicate_main=eye_data_drop_duplicate[eye_data_drop_duplicate['SPORTS_STEP_NM']=='본운동']
eye_data_drop_duplicate_main.head()


# In[22]:


#시각장애 마무리 운동 종류
eye_data_drop_duplicate_finish=eye_data_drop_duplicate[eye_data_drop_duplicate['SPORTS_STEP_NM']=='마무리운동']
eye_data_drop_duplicate_finish.head()


# # 

# # 2) 청각 장애 데이터 분석

# In[23]:


#전 등급 청각 장애 데이터
ear_data = pd.DataFrame()
ear_data = data[data['TROBL_TY_NM']=='청각장애']
ear_data


# In[24]:


#청각 장애인 준비 운동 빈도 수
ear_data_pre_count = pd.DataFrame()
ear_data_pre_count = data[(data['TROBL_TY_NM']=='청각장애') & (data['SPORTS_STEP_NM']=='준비운동')]
ear_data_pre_count['RECOMEND_MVM_NM'].value_counts()


# In[25]:


#청각 장애인 본 운동 빈도 수
ear_data_main_count = pd.DataFrame()
ear_data_main_count_a = pd.DataFrame()
ear_data_main_count = data[(data['TROBL_TY_NM']=='청각장애') & (data['SPORTS_STEP_NM']=='본운동')]
ear_data_main_count['RECOMEND_MVM_NM'].value_counts()


# In[26]:


#청각 장애인 본 운동 빈도 수
ear_data_finish_count = pd.DataFrame()
ear_data_finish_count = data[(data['TROBL_TY_NM']=='청각장애') & (data['SPORTS_STEP_NM']=='마무리운동')]
ear_data_finish_count['RECOMEND_MVM_NM'].value_counts()


# ## 청각장애 운동 중복 제거

# In[27]:


#중복 제거된 청각 장애 운동 개수
ear_data_drop_duplicate=ear_data.drop_duplicates(['RECOMEND_MVM_NM'])
ear_data.drop_duplicates(['RECOMEND_MVM_NM']).shape[0]


# In[28]:


#중복 제거된 시각 장애 운동 데이터
ear_data_drop_duplicate.head()


# In[29]:


#청각장애 준비운동 종류
ear_data_drop_duplicate_pre=ear_data_drop_duplicate[ear_data_drop_duplicate['SPORTS_STEP_NM']=='준비운동']
ear_data_drop_duplicate_pre.head()


# In[30]:


#청각장애 본운동 종류
ear_data_drop_duplicate_main=ear_data_drop_duplicate[ear_data_drop_duplicate['SPORTS_STEP_NM']=='본운동']
ear_data_drop_duplicate_main.head()


# In[31]:


#청각장애 마무리 운동 종류
ear_data_drop_duplicate_finish=ear_data_drop_duplicate[ear_data_drop_duplicate['SPORTS_STEP_NM']=='마무리운동']
ear_data_drop_duplicate_finish.head()


# # 

# # 3) 지적 장애 데이터 분석

# In[32]:


#전 등급 지적 장애 데이터
mental_data = pd.DataFrame()
mental_data = data[data['TROBL_TY_NM']=='지적장애']
mental_data


# In[33]:


#지적 장애인 준비 운동 빈도 수
mental_data_pre_count = pd.DataFrame()
mental_data_pre_count = data[(data['TROBL_TY_NM']=='지적장애') & (data['SPORTS_STEP_NM']=='준비운동')]
mental_data_pre_count['RECOMEND_MVM_NM'].value_counts()


# In[34]:


#지적 장애인 본 운동 빈도 수
mental_data_main_count = pd.DataFrame()
mental_data_main_count = data[(data['TROBL_TY_NM']=='지적장애') & (data['SPORTS_STEP_NM']=='본운동')]
mental_data_main_count['RECOMEND_MVM_NM'].value_counts()


# In[35]:


#지적 장애인 마무리 운동 빈도 수
mental_data_finish_count = pd.DataFrame()
mental_data_finish_count = data[(data['TROBL_TY_NM']=='지적장애') & (data['SPORTS_STEP_NM']=='마무리운동')]
mental_data_finish_count['RECOMEND_MVM_NM'].value_counts()


# ## 지적장애 운동 중복 제거

# In[36]:


#중복 제거된 지적 장애 운동 개수
mental_data_drop_duplicate=mental_data.drop_duplicates(['RECOMEND_MVM_NM'])
mental_data.drop_duplicates(['RECOMEND_MVM_NM']).shape[0]


# In[37]:


#중복 제거된 지적 장애 운동 데이터
mental_data_drop_duplicate.head()


# In[38]:


#지적장애 준비운동 종류
mental_data_drop_duplicate_pre=mental_data_drop_duplicate[mental_data_drop_duplicate['SPORTS_STEP_NM']=='준비운동']
mental_data_drop_duplicate_pre.head()


# In[39]:


#지적장애 본운동 종류
mental_data_drop_duplicate_main=mental_data_drop_duplicate[mental_data_drop_duplicate['SPORTS_STEP_NM']=='본운동']
mental_data_drop_duplicate_main.head()


# In[40]:


#지적장애 마무리운동 종류
mental_data_drop_duplicate_finish=mental_data_drop_duplicate[mental_data_drop_duplicate['SPORTS_STEP_NM']=='마무리운동']
mental_data_drop_duplicate_finish.head()


# # 

# # 4) 척수 장애 데이터 분석

# In[41]:


#전 등급 지적 장애 데이터
myelopathy_data = pd.DataFrame()
myelopathy_data = data[data['TROBL_TY_NM']=='척수장애']
myelopathy_data


# In[42]:


#척수 장애인 준비 운동 빈도 수
myelopathy_data_pre_count = pd.DataFrame()
myelopathy_data_pre_count = data[(data['TROBL_TY_NM']=='척수장애') & (data['SPORTS_STEP_NM']=='준비운동')]
myelopathy_data_pre_count['RECOMEND_MVM_NM'].value_counts()


# In[43]:


#척수 장애인 본 운동 빈도 수
myelopathy_data_main_count = pd.DataFrame()
myelopathy_data_main_count = data[(data['TROBL_TY_NM']=='척수장애') & (data['SPORTS_STEP_NM']=='본운동')]
myelopathy_data_main_count['RECOMEND_MVM_NM'].value_counts()


# In[44]:


#척수 장애인 마무리 운동 빈도 수
myelopathy_data_finish_count = pd.DataFrame()
myelopathy_data_finish_count = data[(data['TROBL_TY_NM']=='척수장애') & (data['SPORTS_STEP_NM']=='마무리운동')]
myelopathy_data_finish_count['RECOMEND_MVM_NM'].value_counts()


# ## 척수장애 운동 중복 제거

# In[45]:


#중복 제거된 척수 장애 운동 개수
myelopathy_data_drop_duplicate=myelopathy_data.drop_duplicates(['RECOMEND_MVM_NM'])
myelopathy_data.drop_duplicates(['RECOMEND_MVM_NM']).shape[0]


# In[46]:


#중복 제거된 척수 장애 운동 데이터
myelopathy_data_drop_duplicate.head()


# In[47]:


#척수장애 준비운동 종류
myelopathy_data_drop_duplicate_pre=myelopathy_data_drop_duplicate[myelopathy_data_drop_duplicate['SPORTS_STEP_NM']=='준비운동']
myelopathy_data_drop_duplicate_pre.head()


# In[48]:


#척수장애 본 운동 종류
myelopathy_data_drop_duplicate_main=myelopathy_data_drop_duplicate[myelopathy_data_drop_duplicate['SPORTS_STEP_NM']=='본운동']
myelopathy_data_drop_duplicate_main.head()


# In[49]:


#척수장애 마무리 운동 종류
myelopathy_data_drop_duplicate_finish=myelopathy_data_drop_duplicate[myelopathy_data_drop_duplicate['SPORTS_STEP_NM']=='마무리운동']
myelopathy_data_drop_duplicate_finish.head()


# 

# # 장애 별 추천 운동 목록 추출

# ## 1-1) 시각 장애 준비 운동 추천 목록

# In[50]:


#시각장애 준비 운동 빈도 수 열 추가
eye_data_drop_duplicate_pre=eye_data_drop_duplicate_pre.copy()
eye_data_drop_duplicate_pre['freq'] = eye_data_pre_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

#불필요한 데이터 제거
eye_data_drop_duplicate_pre=eye_data_drop_duplicate_pre.drop(['AGRDE_FLAG_NM'],axis=1)
eye_data_drop_duplicate_pre=eye_data_drop_duplicate_pre.drop(['SEXDSTN_FLAG_CD'],axis=1)
eye_data_drop_duplicate_pre=eye_data_drop_duplicate_pre.drop(['TROBL_DETAIL_NM'],axis=1)
eye_data_drop_duplicate_pre=eye_data_drop_duplicate_pre.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

#비율 열 추가(비율=빈도 수/전체 빈도 수)
eye_data_drop_duplicate_pre['percent'] = eye_data_drop_duplicate_pre['freq'] / (eye_data_drop_duplicate_pre['freq'].sum())

#복원 랜덤 샘플링, 비율을 가중치로 두어 랜덤 30개 추출
eye_warmup=pd.DataFrame()
eye_warmup=eye_data_drop_duplicate_pre.sample(n=30,replace=True, weights='percent')

#병합할 때 불필요한 열 제거
eye_warmup=eye_warmup.rename(columns={'RECOMEND_MVM_NM':'WarmUp'})
eye_warmup=eye_warmup.drop(['TROBL_GRAD_NM'],axis=1)
eye_warmup=eye_warmup.drop(['SPORTS_STEP_NM'],axis=1)
eye_warmup=eye_warmup.drop(['freq'],axis=1)
eye_warmup=eye_warmup.drop(['percent'],axis=1)
eye_warmup.head()


# ## 1-2) 시각장애 본운동 추천 목록

# In[51]:


eye_data_drop_duplicate_main=eye_data_drop_duplicate_main.copy()
eye_data_drop_duplicate_main['freq'] = eye_data_main_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

eye_data_drop_duplicate_main=eye_data_drop_duplicate_main.drop(['AGRDE_FLAG_NM'],axis=1)
eye_data_drop_duplicate_main=eye_data_drop_duplicate_main.drop(['SEXDSTN_FLAG_CD'],axis=1)
eye_data_drop_duplicate_main=eye_data_drop_duplicate_main.drop(['TROBL_DETAIL_NM'],axis=1)
eye_data_drop_duplicate_main=eye_data_drop_duplicate_main.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

eye_data_drop_duplicate_main['percent'] = eye_data_drop_duplicate_main['freq'] / (eye_data_drop_duplicate_main['freq'].sum())

eye_main=pd.DataFrame()
eye_main=eye_data_drop_duplicate_main.sample(n=30,replace=True, weights='percent')

eye_main=eye_main.rename(columns={'RECOMEND_MVM_NM':'Main'})
eye_main=eye_main.drop(['TROBL_GRAD_NM'],axis=1)
eye_main=eye_main.drop(['SPORTS_STEP_NM'],axis=1)
eye_main=eye_main.drop(['freq'],axis=1)
eye_main=eye_main.drop(['percent'],axis=1)
eye_main.head()


# ## 1-3) 시각 장애 마무리 운동 추천 목록

# In[52]:


eye_data_drop_duplicate_finish=eye_data_drop_duplicate_finish.copy()
eye_data_drop_duplicate_finish['freq'] = eye_data_finish_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

eye_data_drop_duplicate_finish=eye_data_drop_duplicate_finish.drop(['AGRDE_FLAG_NM'],axis=1)
eye_data_drop_duplicate_finish=eye_data_drop_duplicate_finish.drop(['SEXDSTN_FLAG_CD'],axis=1)
eye_data_drop_duplicate_finish=eye_data_drop_duplicate_finish.drop(['TROBL_DETAIL_NM'],axis=1)
eye_data_drop_duplicate_finish=eye_data_drop_duplicate_finish.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

eye_data_drop_duplicate_finish['percent'] = eye_data_drop_duplicate_finish['freq'] / (eye_data_drop_duplicate_finish['freq'].sum())

eye_finish=pd.DataFrame()
eye_finish=eye_data_drop_duplicate_finish.sample(n=30,replace=True, weights='percent')

eye_finish=eye_finish.rename(columns={'RECOMEND_MVM_NM':'Finish'})
eye_finish=eye_finish.drop(['TROBL_GRAD_NM'],axis=1)
eye_finish=eye_finish.drop(['SPORTS_STEP_NM'],axis=1)
eye_finish=eye_finish.drop(['freq'],axis=1)
eye_finish=eye_finish.drop(['percent'],axis=1)
eye_finish.head()


# ## 2-1) 청각 장애 준비 운동 추천 목록

# In[53]:


ear_data_drop_duplicate_pre=ear_data_drop_duplicate_pre.copy()
ear_data_drop_duplicate_pre['freq'] = ear_data_pre_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

ear_data_drop_duplicate_pre=ear_data_drop_duplicate_pre.drop(['AGRDE_FLAG_NM'],axis=1)
ear_data_drop_duplicate_pre=ear_data_drop_duplicate_pre.drop(['SEXDSTN_FLAG_CD'],axis=1)
ear_data_drop_duplicate_pre=ear_data_drop_duplicate_pre.drop(['TROBL_DETAIL_NM'],axis=1)
ear_data_drop_duplicate_pre=ear_data_drop_duplicate_pre.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

ear_data_drop_duplicate_pre['percent'] = ear_data_drop_duplicate_pre['freq'] / (ear_data_drop_duplicate_pre['freq'].sum())

ear_warmup=pd.DataFrame()
ear_warmup=ear_data_drop_duplicate_pre.sample(n=30,replace=True, weights='percent')

ear_warmup=ear_warmup.rename(columns={'RECOMEND_MVM_NM':'WarmUp'})
ear_warmup=ear_warmup.drop(['TROBL_GRAD_NM'],axis=1)
ear_warmup=ear_warmup.drop(['SPORTS_STEP_NM'],axis=1)
ear_warmup=ear_warmup.drop(['freq'],axis=1)
ear_warmup=ear_warmup.drop(['percent'],axis=1)
ear_warmup.head()


# ## 2-2) 청각 장애 본 운동 추천 목록

# In[54]:


ear_data_drop_duplicate_main=ear_data_drop_duplicate_main.copy()
ear_data_drop_duplicate_main['freq'] = ear_data_main_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

ear_data_drop_duplicate_main=ear_data_drop_duplicate_main.drop(['AGRDE_FLAG_NM'],axis=1)
ear_data_drop_duplicate_main=ear_data_drop_duplicate_main.drop(['SEXDSTN_FLAG_CD'],axis=1)
ear_data_drop_duplicate_main=ear_data_drop_duplicate_main.drop(['TROBL_DETAIL_NM'],axis=1)
ear_data_drop_duplicate_main=ear_data_drop_duplicate_main.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

ear_data_drop_duplicate_main['percent'] = ear_data_drop_duplicate_main['freq'] / (ear_data_drop_duplicate_main['freq'].sum())

ear_main=pd.DataFrame()
ear_main=ear_data_drop_duplicate_main.sample(n=30,replace=True, weights='percent')

ear_main=ear_main.rename(columns={'RECOMEND_MVM_NM':'Main'})
ear_main=ear_main.drop(['TROBL_GRAD_NM'],axis=1)
ear_main=ear_main.drop(['SPORTS_STEP_NM'],axis=1)
ear_main=ear_main.drop(['freq'],axis=1)
ear_main=ear_main.drop(['percent'],axis=1)
ear_main.head()


# ## 2-3) 청각 장애 마무리 운동 추천 목록

# In[55]:


ear_data_drop_duplicate_finish=ear_data_drop_duplicate_finish.copy()
ear_data_drop_duplicate_finish['freq'] = ear_data_finish_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

ear_data_drop_duplicate_finish=ear_data_drop_duplicate_finish.drop(['AGRDE_FLAG_NM'],axis=1)
ear_data_drop_duplicate_finish=ear_data_drop_duplicate_finish.drop(['SEXDSTN_FLAG_CD'],axis=1)
ear_data_drop_duplicate_finish=ear_data_drop_duplicate_finish.drop(['TROBL_DETAIL_NM'],axis=1)
ear_data_drop_duplicate_finish=ear_data_drop_duplicate_finish.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

ear_data_drop_duplicate_finish['percent'] = ear_data_drop_duplicate_finish['freq'] / (ear_data_drop_duplicate_finish['freq'].sum())

ear_finish=pd.DataFrame()
ear_finish=ear_data_drop_duplicate_finish.sample(n=30,replace=True, weights='percent')

ear_finish=ear_finish.rename(columns={'RECOMEND_MVM_NM':'Finish'})
ear_finish=ear_finish.drop(['TROBL_GRAD_NM'],axis=1)
ear_finish=ear_finish.drop(['SPORTS_STEP_NM'],axis=1)
ear_finish=ear_finish.drop(['freq'],axis=1)
ear_finish=ear_finish.drop(['percent'],axis=1)
ear_finish.head()


# ## 3-1) 지적 장애 준비 운동 추천 목록

# In[56]:


mental_data_drop_duplicate_pre=mental_data_drop_duplicate_pre.copy()
mental_data_drop_duplicate_pre['freq'] = mental_data_pre_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

mental_data_drop_duplicate_pre=mental_data_drop_duplicate_pre.drop(['AGRDE_FLAG_NM'],axis=1)
mental_data_drop_duplicate_pre=mental_data_drop_duplicate_pre.drop(['SEXDSTN_FLAG_CD'],axis=1)
mental_data_drop_duplicate_pre=mental_data_drop_duplicate_pre.drop(['TROBL_DETAIL_NM'],axis=1)
mental_data_drop_duplicate_pre=mental_data_drop_duplicate_pre.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

mental_data_drop_duplicate_pre['percent'] = mental_data_drop_duplicate_pre['freq'] / (mental_data_drop_duplicate_pre['freq'].sum())

mental_warmup=pd.DataFrame()
mental_warmup=mental_data_drop_duplicate_pre.sample(n=30,replace=True, weights='percent')

mental_warmup=mental_warmup.rename(columns={'RECOMEND_MVM_NM':'WarmUp'})
mental_warmup=mental_warmup.drop(['TROBL_GRAD_NM'],axis=1)
mental_warmup=mental_warmup.drop(['SPORTS_STEP_NM'],axis=1)
mental_warmup=mental_warmup.drop(['freq'],axis=1)
mental_warmup=mental_warmup.drop(['percent'],axis=1)
mental_warmup.head()


# ## 3-2) 지적 장애 본 운동 추천 목록

# In[57]:


mental_data_drop_duplicate_main=mental_data_drop_duplicate_main.copy()
mental_data_drop_duplicate_main['freq'] = mental_data_main_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

mental_data_drop_duplicate_main=mental_data_drop_duplicate_main.drop(['AGRDE_FLAG_NM'],axis=1)
mental_data_drop_duplicate_main=mental_data_drop_duplicate_main.drop(['SEXDSTN_FLAG_CD'],axis=1)
mental_data_drop_duplicate_main=mental_data_drop_duplicate_main.drop(['TROBL_DETAIL_NM'],axis=1)
mental_data_drop_duplicate_main=mental_data_drop_duplicate_main.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

mental_data_drop_duplicate_main['percent'] = mental_data_drop_duplicate_main['freq'] / (mental_data_drop_duplicate_main['freq'].sum())

mental_main=pd.DataFrame()
mental_main= mental_data_drop_duplicate_main.sample(n=30,replace=True, weights='percent')

mental_main=mental_main.rename(columns={'RECOMEND_MVM_NM':'Main'})
mental_main=mental_main.drop(['TROBL_GRAD_NM'],axis=1)
mental_main=mental_main.drop(['SPORTS_STEP_NM'],axis=1)
mental_main=mental_main.drop(['freq'],axis=1)
mental_main=mental_main.drop(['percent'],axis=1)
mental_main.head()


# ## 3-3) 지적 장애 마무리 운동 추천 목록

# In[58]:


mental_data_drop_duplicate_finish=mental_data_drop_duplicate_finish.copy()
mental_data_drop_duplicate_finish['freq'] = mental_data_finish_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

mental_data_drop_duplicate_finish=mental_data_drop_duplicate_finish.drop(['AGRDE_FLAG_NM'],axis=1)
mental_data_drop_duplicate_finish=mental_data_drop_duplicate_finish.drop(['SEXDSTN_FLAG_CD'],axis=1)
mental_data_drop_duplicate_finish=mental_data_drop_duplicate_finish.drop(['TROBL_DETAIL_NM'],axis=1)
mental_data_drop_duplicate_finish=mental_data_drop_duplicate_finish.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

mental_data_drop_duplicate_finish['percent'] = mental_data_drop_duplicate_finish['freq'] / (mental_data_drop_duplicate_finish['freq'].sum())

mental_finish=pd.DataFrame()
mental_finish=mental_data_drop_duplicate_finish.sample(n=30,replace=True, weights='percent')

mental_finish=mental_finish.rename(columns={'RECOMEND_MVM_NM':'Finish'})
mental_finish=mental_finish.drop(['TROBL_GRAD_NM'],axis=1)
mental_finish=mental_finish.drop(['SPORTS_STEP_NM'],axis=1)
mental_finish=mental_finish.drop(['freq'],axis=1)
mental_finish=mental_finish.drop(['percent'],axis=1)
mental_finish.head()


# ## 4-1) 척수 장애 준비 운동 추천 목록

# In[59]:


myelopathy_data_drop_duplicate_pre=myelopathy_data_drop_duplicate_pre.copy()
myelopathy_data_drop_duplicate_pre['freq'] = myelopathy_data_pre_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

myelopathy_data_drop_duplicate_pre=myelopathy_data_drop_duplicate_pre.drop(['AGRDE_FLAG_NM'],axis=1)
myelopathy_data_drop_duplicate_pre=myelopathy_data_drop_duplicate_pre.drop(['SEXDSTN_FLAG_CD'],axis=1)
myelopathy_data_drop_duplicate_pre=myelopathy_data_drop_duplicate_pre.drop(['TROBL_DETAIL_NM'],axis=1)
myelopathy_data_drop_duplicate_pre=myelopathy_data_drop_duplicate_pre.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

myelopathy_data_drop_duplicate_pre['percent'] = myelopathy_data_drop_duplicate_pre['freq'] / (myelopathy_data_drop_duplicate_pre['freq'].sum())

myelopathy_warmup=pd.DataFrame()
myelopathy_warmup=myelopathy_data_drop_duplicate_pre.sample(n=30,replace=True, weights='percent')

myelopathy_warmup=myelopathy_warmup.rename(columns={'RECOMEND_MVM_NM':'WarmUp'})
myelopathy_warmup=myelopathy_warmup.drop(['TROBL_GRAD_NM'],axis=1)
myelopathy_warmup=myelopathy_warmup.drop(['SPORTS_STEP_NM'],axis=1)
myelopathy_warmup=myelopathy_warmup.drop(['freq'],axis=1)
myelopathy_warmup=myelopathy_warmup.drop(['percent'],axis=1)
myelopathy_warmup.head()


# ## 4-2) 척수 장애 본 운동 추천 목록

# In[60]:


myelopathy_data_drop_duplicate_main=myelopathy_data_drop_duplicate_main.copy()
myelopathy_data_drop_duplicate_main['freq'] = myelopathy_data_main_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')

myelopathy_data_drop_duplicate_main=myelopathy_data_drop_duplicate_main.drop(['AGRDE_FLAG_NM'],axis=1)
myelopathy_data_drop_duplicate_main=myelopathy_data_drop_duplicate_main.drop(['SEXDSTN_FLAG_CD'],axis=1)
myelopathy_data_drop_duplicate_main=myelopathy_data_drop_duplicate_main.drop(['TROBL_DETAIL_NM'],axis=1)
myelopathy_data_drop_duplicate_main=myelopathy_data_drop_duplicate_main.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

myelopathy_data_drop_duplicate_main['percent'] = myelopathy_data_drop_duplicate_main['freq'] / (myelopathy_data_drop_duplicate_main['freq'].sum())

myelopathy_main=pd.DataFrame()
myelopathy_main=myelopathy_data_drop_duplicate_main.sample(n=30,replace=True, weights='percent')

myelopathy_main=myelopathy_main.rename(columns={'RECOMEND_MVM_NM':'Main'})
myelopathy_main=myelopathy_main.drop(['TROBL_GRAD_NM'],axis=1)
myelopathy_main=myelopathy_main.drop(['SPORTS_STEP_NM'],axis=1)
myelopathy_main=myelopathy_main.drop(['freq'],axis=1)
myelopathy_main=myelopathy_main.drop(['percent'],axis=1)
myelopathy_main.head()


# ## 4-3) 척수 장애 마무리 운동 추천 목록

# In[61]:


myelopathy_data_drop_duplicate_finish=myelopathy_data_drop_duplicate_finish.copy()
myelopathy_data_drop_duplicate_finish['freq'] = myelopathy_data_finish_count.groupby('RECOMEND_MVM_NM')['RECOMEND_MVM_NM'].transform('count')
myelopathy_data_drop_duplicate_finish

myelopathy_data_drop_duplicate_finish=myelopathy_data_drop_duplicate_finish.drop(['AGRDE_FLAG_NM'],axis=1)
myelopathy_data_drop_duplicate_finish=myelopathy_data_drop_duplicate_finish.drop(['SEXDSTN_FLAG_CD'],axis=1)
myelopathy_data_drop_duplicate_finish=myelopathy_data_drop_duplicate_finish.drop(['TROBL_DETAIL_NM'],axis=1)
myelopathy_data_drop_duplicate_finish=myelopathy_data_drop_duplicate_finish.drop(['FLAG_ACCTO_RECOMEND_MVM_RANK_CO'],axis=1)

myelopathy_data_drop_duplicate_finish['percent'] = myelopathy_data_drop_duplicate_finish['freq'] / (myelopathy_data_drop_duplicate_finish['freq'].sum())

myelopathy_finish=pd.DataFrame()
myelopathy_finish=myelopathy_data_drop_duplicate_finish.sample(n=30,replace=True, weights='percent')

myelopathy_finish=myelopathy_finish.rename(columns={'RECOMEND_MVM_NM':'Finish'})
myelopathy_finish=myelopathy_finish.drop(['TROBL_GRAD_NM'],axis=1)
myelopathy_finish=myelopathy_finish.drop(['SPORTS_STEP_NM'],axis=1)
myelopathy_finish=myelopathy_finish.drop(['freq'],axis=1)
myelopathy_finish=myelopathy_finish.drop(['percent'],axis=1)
myelopathy_finish.head()


# 

# # 각 장애 별 준비/본/마무리 운동 추천 목록 병합

# ## 시각장애 운동 추천 목록

# In[62]:


#인덱스 리셋
eye_warmup=eye_warmup.reset_index(drop='True')
eye_main=eye_main.reset_index(drop='True')
eye_finish=eye_finish.reset_index(drop='True')

#장애 유형 중복 제거
eye_main=eye_main.drop(['TROBL_TY_NM'],axis=1)
eye_finish=eye_finish.drop(['TROBL_TY_NM'],axis=1)

#준비/본/마무리 데이터 합치기
eye_data = pd.concat([eye_warmup,eye_main], axis=1)
eye_data = pd.concat([eye_data,eye_finish], axis=1)
eye_data


# ## 청각장애 운동 추천 목록

# In[63]:


ear_warmup=ear_warmup.reset_index(drop='True')
ear_main=ear_main.reset_index(drop='True')
ear_finish=ear_finish.reset_index(drop='True')

ear_main=ear_main.drop(['TROBL_TY_NM'],axis=1)
ear_finish=ear_finish.drop(['TROBL_TY_NM'],axis=1)

ear_data = pd.concat([ear_warmup,ear_main], axis=1)
ear_data = pd.concat([ear_data,ear_finish], axis=1)
ear_data


# ## 지적 장애 운동 추천 목록

# In[64]:


mental_warmup=mental_warmup.reset_index(drop='True')
mental_main=mental_main.reset_index(drop='True')
mental_finish=mental_finish.reset_index(drop='True')

mental_main=mental_main.drop(['TROBL_TY_NM'],axis=1)
mental_finish=mental_finish.drop(['TROBL_TY_NM'],axis=1)

mental_data = pd.concat([mental_warmup,mental_main], axis=1)
mental_data = pd.concat([mental_data,mental_finish], axis=1)
mental_data


# ## 척수 장애 운동 추천 목록

# In[65]:


myelopathy_warmup=myelopathy_warmup.reset_index(drop='True')
myelopathy_main=myelopathy_main.reset_index(drop='True')
myelopathy_finish=myelopathy_finish.reset_index(drop='True')

myelopathy_main=myelopathy_main.drop(['TROBL_TY_NM'],axis=1)
myelopathy_finish=myelopathy_finish.drop(['TROBL_TY_NM'],axis=1)

myelopathy_data = pd.concat([myelopathy_warmup,myelopathy_main], axis=1)
myelopathy_data = pd.concat([myelopathy_data,myelopathy_finish], axis=1)
myelopathy_data


# In[67]:


#데이터 저장
#eye_data.to_csv("./data/eyedata.csv", index = False, encoding = 'utf-8' )
#ear_data.to_csv("./data/eardata.csv", index = False, encoding = 'utf-8' )
#mental_data.to_csv("./data/mentaldata.csv", index = False, encoding = 'utf-8' )
#myelopathy_data.to_csv("./data/myelopathydata.csv", index = False, encoding = 'utf-8' )

